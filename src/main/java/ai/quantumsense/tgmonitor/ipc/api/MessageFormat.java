package ai.quantumsense.tgmonitor.ipc.api;


/***
 * <p>Message format</p>
 *
 * <p>The following describes the formats of the message bodies exchanged
 * between the core and the UI instances.</p>
 *
 * <p><i>Note that there is always a single core instance, but there may be zero,
 * one, or multiple UI instances.</i></p>
 *
 * <p>In principle, the exchanged messages are <b>UTF-8</b>-encoded <b>JSON</b>
 * strings.</p>
 *
 * <p>There are two types of messages, requests and responses, and they are
 * encoded in detail as follows:</p>
 *
 * <p><b>Requests:</b> encoded as a <b>JSON array</b>.</p>
 * <ul>
 *     <li>
 *          The first element of the array is the request name, which must be
 *          one of the constants defined in {@link UiToCoreRequests} and
 *          {@link CoreToUiRequests}.
 *     </li>
 *     <li>
 *          The optional subsequent elements of the array are the request
 *          arguments, encoded as appropriate JSON data types.
 *     </li>
 *     <li>
 *          Only the first element of the array is mandatory. For example, if
 *          the request has no arguments, then the array consists only of a
 *          single element, which is the request name.
 *     </li>
 *     <li>
 *         Example requests:
 *         <ul>
 *             <li>{@code ["login", "+41791234567", "66587740-72ad-408f"]}</li>
 *             <li>{@code ["set_peers", ["alethena_official", "tezosico", "icocountdown"]]}</li>
 *             <li>{@code ["get_peers"]}</li>
 *         </ul>
 *     </li>
 * </ul>
 *
 * <p><b>Responses:</b> encoded as a single <b>JSON value</b> of any data type.</p>
 * <ul>
 *      <li>
 *          A response consists of a single value which can be any of the 6
 *          JSON data types: <i>string</i>, <i>number</i>, <i>boolean</i>,
 *          <i>null</i>, <i>array</i>, and <i>object</i>.
 *      </li>
 *      <li>
 *          If the response belongs to a request that returns no value, then
 *          the message body is simply empty.
 *      </li>
 *      <li>
 *         Example responses:
 *         <ul>
 *             <li>{@code true}</li>
 *             <li>{@code "+417912345678"}</li>
 *             <li>{@code ["alethena_official", "tezosico", "icocountdown"]}</li>
 *         </ul>
 *      </li>
 * </ul>
 */
public final class MessageFormat {

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
    public static final class UiToCoreRequests {

        /**
         * {@value LOGIN} (phone_number:string, ui_instance_id:string) : ()
         *
         * <p><b>Considerations for core:</b></p>
         *
         * <p>This request triggers a nested GET_LOGIN_CODE request (see
         * {@link CoreToUiRequests}) back to the UI. The LOGIN request cannot
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


        private UiToCoreRequests() {}

    }

    /**
     * Names of requests and notifications sent from the core to the
     * UI instances.
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
    public static final class CoreToUiRequests {

        /**
         * {@value GET_LOGIN_CODE} (ui_instance_id:string) : (string)
         *
         * <p><b>Considerations for core:</b></p>
         *
         * <p>The GET_LOGIN_CODE request must provide as argument the UI
         * instance ID that was initially provided by the UI in the LOGIN
         * request (see {@link UiToCoreRequests}). This is in order to allow
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

        private CoreToUiRequests() {}
    }

    public static final class HeaderKeys {
        public static final String LOGIN_CODE_REQUEST_QUEUE = "login_code_request_queue";
    }

    private MessageFormat() {}
}
