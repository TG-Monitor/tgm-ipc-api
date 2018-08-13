package ai.quantumsense.tgmonitor.ipc.api;

/**
 * <p>RabbitMQ queues</p>
 *
 * <p>The RabbitMQ queue architecture looks as follows:</p>
 * <ul>
 *     <li>There is a single queue {@value REQUEST_QUEUE} to which all the
 *     UI instances send requests to the core.
 *     <ul>
 *          <li>UI instances specify response queue in {@code reply_to} property.</li>
 *     </ul></li>
 *     <li>There is a single queue {@value BROADCAST_QUEUE} to which the
 *     core sends broadcasts to all the UI instances.
 *     <ul>
 *          <li>Broadcasts require no responses.</li>
 *     </ul></li>
 * </ul>
 *
 * <p><i>Note that there is always a single core instance, but there may be zero,
 * one, or multiple UI instances.</i></p>
 */
public final class Queues {

    /**
     * <b>{@value REQUEST_QUEUE}</b>
     *
     * <p>Queue to which the UI instances send requests ot the core. This
     * queue is declared by the core, and it has always a single consumer (the
     * core).</p>
     *
     * <p>Core: declare as durable = false, exclusive = true, auto-delete = true</p>
     */
    public static final String REQUEST_QUEUE = "requests_to_core";

    /**
     * <b>{@value BROADCAST_QUEUE}</b>
     *
     * <p>Queue to which the core sends broadcast messages to the UI instances.</p>
     *
     * <p>This queue is declared by the UI instances, and the UI instances are
     * responsible to run consumers on this queue in order to receive broadcasts
     * from the core.</p>
     *
     * <p>UI instances: declare as durable = false, exclusive = false,
     * auto-delete = true</p>
     */
    public static final String BROADCAST_QUEUE = "broadcasts_to_ui";

    private Queues() {}
}
