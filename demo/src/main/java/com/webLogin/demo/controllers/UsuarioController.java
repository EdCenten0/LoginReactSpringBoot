package com.webLogin.demo.controllers;

import com.webLogin.demo.dao.UsuarioDao;
import com.webLogin.demo.models.Usuario;
import com.webLogin.demo.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class UsuarioController {


    @Autowired
    private UsuarioDao usuarioDao;


    @RequestMapping(value= "api/usuario/{id}", method = RequestMethod.GET   )
    public Usuario getUsuario(@PathVariable Long id)
    {

        Usuario denisse = new Usuario();
        denisse.setId(id);
        denisse.setNombre("Denisse");
        denisse.setApellido("Aguilar");
        denisse.setEmail("daguilar@gmail.com");
        denisse.setPassword("prueba");

        return denisse;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.POST)
    public void registrarUsuario(@RequestBody Usuario usuario){
        System.out.println("Usuario recibido: " + usuario.toString());

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, usuario.getPassword());
        usuario.setPassword(hash);
        usuarioDao.registrar(usuario);
    }

    @RequestMapping(value = "api/usuarios")
    public List<Usuario> getUsuarios(){
        return usuarioDao.getUsuarios();
    }
}
