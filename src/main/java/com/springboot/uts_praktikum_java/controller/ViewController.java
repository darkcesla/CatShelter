package com.springboot.uts_praktikum_java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/CatShelter")
public class ViewController {
	@RequestMapping("/")
	public String login() {
		return "login";
	}
	@RequestMapping("/daftar-akun")
	public String register() {
		return "registrasi";
	}
	@RequestMapping("/adopsi-kucing")
	public String kucing() {
		return "cat";
	}
	@RequestMapping("/beli-produk")
	public String product() {
		return "produk";
	}
	@RequestMapping("/home")
	public String index() {
		return "beranda";
	}
}
