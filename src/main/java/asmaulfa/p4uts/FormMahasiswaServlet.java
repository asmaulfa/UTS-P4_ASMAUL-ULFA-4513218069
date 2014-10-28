package asmaulfa.p4uts;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FormMahasiswaServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Mahasiswa m = new Mahasiswa();
        m.setNpm(Integer.parseInt(request.getParameter("npm")));
        m.setNama(request.getParameter("nama"));
        m.setTempat_lahir(request.getParameter("tempat_lhr"));
        m.setTanggal_lahir(request.getParameter("tanggal_lhr"));
        m.setJenis_kelamin(request.getParameter("jenis"));
        m.setAlamat(request.getParameter("alamat"));
        
        MahasiswaDao md = new MahasiswaDao();
        md.simpan(m);
        
        RequestDispatcher rd = request.getRequestDispatcher("index.html");
        rd.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
