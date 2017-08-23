package admin;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mackApp.backend.WebRobot;
import mackApp.backend.tia.TIAController;
import mackApp.backend.moodle.MoodleController;

/**
 *
 * @author Nexor
 */
@WebServlet(urlPatterns = {"/AjaxController"})
public class AjaxController extends HttpServlet {

    private static TIAController tc;
    private static MoodleController mc;
//    private static Controller mainController;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (WebRobot.PHANTOMJS_EXECUTABLE_PATH == null) {
            WebRobot.PHANTOMJS_EXECUTABLE_PATH = "D:\\Google Drive\\Programming\\Java\\WebMack\\lib\\phantomjs.exe";// THIS MUST BE CHANGED FOR YOU
        }
        String source = request.getParameter("clickSource");
        String resHTML = "[NO RETURN]";
        response.setContentType("text/plain");
        System.out.println("Clicked " + source);
        switch (source) {
            case "begin":
                try {
                    String[] credentials = parseCookies(request.getCookies());
                    request.getSession().setMaxInactiveInterval(0);
                    while (request.getSession().getAttributeNames().hasMoreElements()) {
                        String key = request.getSession().getAttributeNames().nextElement();
                        System.out.println("\t" + request.getSession().getAttribute(key));
                    }

                    if (credentials[2] == null) {
//                        tc = new TIAController(credentials[0], credentials[1]);
//                        mc = new MoodleController(credentials[0], credentials[1]);
                        
                        response.addCookie(new Cookie("sessionID", request.getSession().getId()));
                    } else {
//                        tc = (TIAController) SerializationUtils.deserialize(credentials[3].getBytes());
//                        mc = (MoodleController) SerializationUtils.deserialize(credentials[4].getBytes());
                    }
                } catch (Exception ex) {
                    Logger.getLogger(AjaxController.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            case "horarios":
                resHTML = tc.getHorariosTable();
                break;
            case "faltas":
                resHTML = tc.getFaltasTable();
                break;
            case "notas":
                resHTML = tc.getNotasTable();
                break;
            case "tarefas":
//                resHTML = mc.getTarefasTable();
                break;
            case "comidas":
                break;
            case "suporte":
                // redirect?
                break;
            case "att":
                long t1 = System.currentTimeMillis();
                tc.query();
                mc.query();
                System.out.println(System.currentTimeMillis() - t1);
                break;
            case "config":
                break;
            default:
                throw new AssertionError();
        }
        response.getWriter().print(resHTML);
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public static String[] parseCookies(Cookie[] cookies) {
        String username = null;
        String password = null;
        String sid = null;
        String tcBytes = null;
        String mcBytes = null;
        for (Cookie c : cookies) {
            if (c.getName().equals("matricula")) {
                username = c.getValue();
            } else if (c.getName().equals("senha")) {
                password = c.getValue();
            } else if (c.getName().equals("sessionID")) {
                sid = c.getValue();
            } else if (c.getName().equals("tc")) {
                tcBytes = c.getValue();
            } else if (c.getName().equals("mc")) {
                mcBytes = c.getValue();
            }
        }
        return new String[]{username, password, sid, tcBytes, mcBytes};
    }

    @Override
    public void destroy() {
        tc.driver.close();
        mc.driver.close();
        super.destroy();
    }
}
