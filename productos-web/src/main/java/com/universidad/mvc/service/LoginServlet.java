@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    // Usuarios en memoria (en producción se consulta la BD)
    private static final Map<String, String> CREDS = Map.of(
            "admin", "Admin123!",
            "viewer", "View456!"
    );
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String user = req.getParameter("username");
        String pass = req.getParameter("password");
        if (user != null && CREDS.containsKey(user) &&
                CREDS.get(user).equals(pass)) {
            HttpSession session = req.getSession(true);
            String rol = "admin".equals(user) ? "ADMIN" : "VIEWER";
            session.setAttribute("usuarioActual",
                    new Usuario(user, user + "@universidad.edu", rol));
            ion.setMaxInactiveInterval(1800);
            resp.sendRedirect(req.getContextPath() + "/productos");
        } else {
            req.setAttribute("errorLogin", "Credenciales incorrectas. Intente de nuevo.");
                    req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);
        }
