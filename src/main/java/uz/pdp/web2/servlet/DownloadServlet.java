package uz.pdp.web2.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import uz.pdp.web2.model.File;
import uz.pdp.web2.service.FileService;

import java.io.IOException;

@WebServlet(name = "DownloadServlet",urlPatterns = "/download")
public class DownloadServlet extends HttpServlet {
    FileService fileService = new FileService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int fileId = Integer.parseInt(req.getParameter("fileId"));
        File file = fileService.get(fileId);
        if(file!=null){
            resp.addHeader("Content-Disposition", "attachment; filename=" + file.getOriginal_name());
            resp.addHeader("Content-Type","application/octet-stream");
            resp.getOutputStream().write(file.getFile());
        }
    }
}
