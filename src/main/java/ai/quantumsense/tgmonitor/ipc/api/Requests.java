package ai.quantumsense.tgmonitor.ipc.api;

/**
 * <p>Names of requests sent from the UI instances to the core.</p>
 *
 * <p>For each request name, the request arguments, and the correesponding
 * response, are described in the following format:</p>
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
     * {@value LOGIN} (phone_number:string, ui_instance_id:string) : ()
     *
     * <p><b>Considerations for core:</b></p>
     *
     * <p>This request triggers a nested GET_LOGIN_CODE request back to the UI.
     * The LOGIN request cannot
     * complete until the GET_LOGIN_CODE request completes. So, the core
     * implementation must make sure that there is no deadlock between the
     * handlers of these two requests.</p>
     *
     * <p>The core should not handle any other requests (from other UI
     * instances) until the entire LOGIN request is completed.</p>
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
     * {@value GET_LOGIN_CODE} (ui_instance_id:string) : (string)
     *
     * <p><b>Considerations for core:</b></p>
     *
     * <p>The GET_LOGIN_CODE request must provide as argument the UI
     * instance ID that was initially provided by the UI in the LOGIN
     * request. This is in order to allow
     * the correct UI instance to respond to the GET_LOGIN_CODE request.</p>
     *
     * <p><b>Considerations for UI instances:</b></p>
     *
     * <p>Conversely, when UI instances receive a GET_LOGIN_CODE request,
     * they must check whether the included UI instance ID argument
     * corresponds to their own UI instance ID, and only if this is the
     * case must they execute the request. Otherwise, they must just
     * ignore it.</p>
     */
    public static final String GET_LOGIN_CODE = "get_login_code";

    private Requests() {}

}
