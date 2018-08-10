package ai.quantumsense.tgmonitor.ipc.api;

/**
 * <p>RabbitMQ queues</p>
 *
 * <p>The RabbitMQ queue architecture looks as follows:</p>
 * <ul>
 *     <li>There is a single queue {@value REQUESTS_TO_CORE} on which the
 *     UI instances send requests to the core.
 *     <ul>
 *          <li>The UI instances specify the queue on which to receive the
 *          response in the {@code reply_to} property of the initial request.</li>
 *     </ul></li>
 *     <li>There is a single queue {@value REQUESTS_TO_UI} on which the
 *     core sends requests and notifications to the UI instances.
 *     <ul>
 *          <li>The core specifies the queue on which to receive the response
 *          in the {@code reply_to} property of the initial request.</li>
 *     </ul></li>
 * </ul>
 *
 * <p>All the requests <b>require a response</b> (even if the request has no return
 * value, in this case, the body of the response is just empty). Only so-called
 * notifications made from the core to the UI instances don't require a response
 * message to be sent back.</p>
 *
 * <p><b>Correlation IDs</b> have to be used for all requests. That is, any party
 * making a request must set the {@code correlation_id} property of the message,
 * and any party receiving a request must copy the correlation ID to the
 * {@code correlation_id} property of the response.</p>
 *
 * <p><i>Note that there is always a single core instance, but there may be zero,
 * one, or multiple UI instances.</i></p>
 */
public final class Queues {

    /**
     * <b>{@value REQUESTS_TO_CORE}</b>
     *
     * <p>Queue to which the UI instances send requests ot the core. This
     * queue is declared by the core, and it has always a single consumer (the
     * core).</p>
     *
     * <p>Core: declare as durable = false, exclusive = true, auto-delete = true</p>
     */
    public static final String REQUESTS_TO_CORE = "requests_to_core";

    /**
     * <b>{@value REQUESTS_TO_UI}</b>
     *
     * <p>Queue to which the core sends requests and notification messages to
     * the UI instances (all the UI instances listen on the same queue).</p>
     *
     * <p>This queue is declared by the UI instances, and the UI instances are
     * responsible to run consumers on this queue in order to receive requests
     * and notifications from the core.</p>
     *
     * <p>UI instances: declare as durable = false, exclusive = false,
     * auto-delete = true</p>
     */
    public static final String REQUESTS_TO_UI = "requests_to_ui";

    private Queues() {}
}
