package ai.quantumsense.tgmonitor.ipc.api;

/**
 * <p>Request names to be used in the exchanged request messages.</p>
 *
 * <p>For each request, the request parameters, as well as the type of response
 * corresponding to the request, are described in the following format:</p>
 *
 * <pre>
 * "name" (name:type, name:type, ...) : (type)
 * |____| |_________________________|   |____|
 *   |                 |                  |
 * request         parameters          response
 * </pre>
 */
public final class Requests {

    /**
     * {@value LOGIN} (phone_number:string) : ()
     *
     * <p>This request triggers a nested GET_LOGIN_CODE request from the core
     * back to the UI instance from which this LOGIN request originated.</p>
     *
     * <p>To this end, this request must have set the header field
     * LOGIN_CODE_REQUEST_QUEUE (see {@link HeaderKeys}) to the name of a queue
     * on which the UI instance listens for the GET_LOGIN_CODE request.</p>
     *
     * <p>This request cannot complete until the nested GET_LOGIN_CODE request
     * completes.</p>
     */
    public static final String LOGIN = "login";

    /**
     * {@value LOGOUT} () : ()
     */
    public static final String LOGOUT = "logout";

    /**
     * {@value IS_LOGGED_IN} () : (boolean)
     */
    public static final String IS_LOGGED_IN = "is_logged_in";

    /**
     * {@value START} () : ()
     */
    public static final String START = "start";

    /**
     * {@value STOP} () : ()
     */
    public static final String STOP = "stop";

    /**
     * {@value IS_RUNNING} () : (boolean)
     */
    public static final String IS_RUNNING = "is_running";

    /**
     * {@value GET_PHONE_NUMBER} () : (string)
     */
    public static final String GET_PHONE_NUMBER = "get_phone_number";



    /**
     * {@value GET_PEERS} () : (array[string])
     */
    public static final String GET_PEERS = "get_peers";

    /**
     * {@value SET_PEERS} (peers:array[string]) : ()
     */
    public static final String SET_PEERS = "set_peers";

    /**
     * {@value ADD_PEER} (peer:string) : ()
     */
    public static final String ADD_PEER = "add_peer";

    /**
     * {@value ADD_PEERS} (peers:array[string]) : ()
     */
    public static final String ADD_PEERS = "add_peers";

    /**
     * {@value REMOVE_PEER} (peer:string) : ()
     */
    public static final String REMOVE_PEER = "remove_peer";

    /**
     * {@value REMOVE_PEERS} (peers:array[string]) : ()
     */
    public static final String REMOVE_PEERS = "remove_peers";



    /**
     * {@value GET_PATTERNS} () : (array[string])
     */
    public static final String GET_PATTERNS = "get_patterns";

    /**
     * {@value SET_PATTERNS} (patterns:array[string]) : ()
     */
    public static final String SET_PATTERNS = "set_patterns";

    /**
     * {@value ADD_PATTERN} (pattern:string) : ()
     */
    public static final String ADD_PATTERN = "add_pattern";

    /**
     * {@value ADD_PATTERNS} (patterns:array[string]) : ()
     */
    public static final String ADD_PATTERNS = "add_patterns";

    /**
     * {@value REMOVE_PATTERN} (pattern:string) : ()
     */
    public static final String REMOVE_PATTERN = "remove_pattern";

    /**
     * {@value REMOVE_PATTERNS} (patterns:array[string]) : ()
     */
    public static final String REMOVE_PATTERNS = "remove_patterns";



    /**
     * {@value GET_EMAILS} () : (array[string])
     */
    public static final String GET_EMAILS = "get_emails";

    /**
     * {@value SET_EMAILS} (emails:array[string]) : ()
     */
    public static final String SET_EMAILS = "set_emails";

    /**
     * {@value ADD_EMAIL} (email:string) : ()
     */
    public static final String ADD_EMAIL = "add_email";

    /**
     * {@value ADD_EMAILS} (emails:array[string]) : ()
     */
    public static final String ADD_EMAILS = "add_emails";

    /**
     * {@value REMOVE_EMAIL} (email:string) : ()
     */
    public static final String REMOVE_EMAIL = "remove_email";

    /**
     * {@value REMOVE_EMAILS} (emails:array[string]) : ()
     */
    public static final String REMOVE_EMAILS = "remove_emails";

    /**
     * {@value GET_LOGIN_CODE} () : (string)
     *
     * <p>This is the only request that is made from the core to an UI instance,
     * rather than vice versa.</p>
     *
     * <p>This request requires no correlation ID, since it is sent to a
     * temporary queue that is declared by the UI instance when it starts a
     * LOGIN request.</p>
     *
     * <p>This request is nested inside a LOGIN request, that is, it is
     * triggered by a LOGIN request and it must complete in order to allow the
     * LOGIN request to complete.</p>
     *
     * <p>Upon receiving this request, the UI instance must prompt the login
     * code from the user and send it back to the core.</p>
     */
    public static final String GET_LOGIN_CODE = "get_login_code";

    private Requests() {}

}
