package com.bca.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/laporan")
public class LaporanController {

	@GetMapping("/harian")
	public String listLaporanHarian() {
		return "admin/laporan_harian";
	}
	
	@GetMapping("/bulanan")
	public String listLaporanBulanan() {
		return "admin/laporan_bulanan";
	}
	
	@GetMapping("/tahunan")
	public String listLaporanTahunan() {
		return "admin/laporan_tahunan";
	}
}
