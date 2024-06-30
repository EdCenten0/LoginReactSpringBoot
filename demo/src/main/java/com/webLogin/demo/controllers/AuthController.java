package com.webLogin.demo.controllers;
import com.webLogin.demo.dao.UsuarioDao;
import com.webLogin.demo.models.Usuario;
import com.webLogin.demo.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {


    @Autowired
    private UsuarioDao usuarioDao;

    @Autowired
    private JWTUtil jwtUtil;


    @RequestMapping(value = "api/usuarios/login", method = RequestMethod.POST)
    public String login(@RequestBody Usuario usuario){

        Usuario  usuarioLogged = usuarioDao.checkCredentials(usuario);

        if(usuarioLogged != null){


           String token = jwtUtil.create(String.valueOf(usuarioLogged.getId()), usuarioLogged.getEmail());

            System.out.println("Hasta aqui bien");
            return token;

        }else {
            System.out.println("Hasta aqui bien");
            return "FAILED";

        }
    }


    @RequestMapping(value =  "api/usuarios/auth", method = RequestMethod.POST)
    public String validateToken(@RequestBody String token){

        System.out.println(token);
        String usuarioId = jwtUtil.getKey(token);
        if(usuarioId != null){
            return  "OK";
        }else{
            return "FAILED";
        }
    }

}
