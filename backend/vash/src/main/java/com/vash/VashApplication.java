package com.vash;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class VashApplication implements CommandLineRunner {

//	@Autowired
//	private ICityService iCityService;
//	@Autowired
//	private IReservationService iReservationService;


	public static void main(String[] args) {
		SpringApplication.run(VashApplication.class, args);
	}

	@Bean
	BCryptPasswordEncoder BCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void run(String... args) throws Exception {

		
		//iMailService.sendEmail("mabrouk.ilias@gmail.com", "test", "Hello toto <>");

//		List<ReservationVo> reservationVos = new ArrayList<ReservationVo>();
//			reservationVos = iReservationService.findByPropertyId(Long.valueOf(1));
			
		
		//List<CityVo> cityVos=iCityService.findAll();
		
//		for (ReservationVo reservationVo : reservationVos) {
//			System.out.println(reservationVo.getId() +" "+reservationVo.getDateEnd());
//		}
		
//		UserVo userVo =new UserVo();
//		userVo.setEmail("hhhh");
//		userVo.setPassword("Toto");
//		userVo.setUserName("hello");
//		
//		iUserService.save(userVo);
//		
//		CityVo cityVo=new CityVo();
//		cityVo.setNameCity("casa");
//		iCityService.save(cityVo);
//		
//		CityVo cityVo2=new CityVo();
//		cityVo2.setNameCity("tanger");
//		iCityService.save(cityVo2);
//		
//		CityVo cityVo3=new CityVo();
//		cityVo3.setNameCity("rabat");
//		iCityService.save(cityVo3);

//		CityVo cityVo=iCityService.findByNameCityIgnoreCase("Rabat");
//		PropertyVo propertyVo=new PropertyVo();
//		propertyVo.setCity(cityVo);
//		propertyVo.setPrice(45d);
//		iPropertyService.save(propertyVo);
//		
//		cityVo=iCityService.findByNameCityIgnoreCase("tanger");
//		PropertyVo propertyV2o=new PropertyVo();
//		propertyV2o.setCity(cityVo);
//		propertyV2o.setPrice(60d);
//		iPropertyService.save(propertyV2o);
//		List<CityVo> CityVos= iCityService.findByNameCityIgnoreCaseContaining("as");
//		for (CityVo cityVo2 : CityVos) {
//			System.out.println(cityVo2.getNameCity());
//		}

//		ReservationVo reservationVo=new ReservationVo();
//		reservationVo.setDateEnd(new Date());
//		reservationVo.setProperty(iPropertyService.findById(1L));
//		ReservationVo reservationVo2=new ReservationVo();
//		reservationVo2.setDateEnd(new Date());
//		reservationVo2.setProperty(iPropertyService.findById(2L));
//		ReservationVo reservationVo3=new ReservationVo();
//		reservationVo3.setDateEnd(new Date());
//		reservationVo3.setProperty(iPropertyService.findById(1L));
//		ReservationVo reservationVo4=new ReservationVo();
//		reservationVo4.setDateEnd(new Date());
//		reservationVo4.setProperty(iPropertyService.findById(1L));
//		
//		iReservationService.save(reservationVo);
//		iReservationService.save(reservationVo2);
//		iReservationService.save(reservationVo3);
//		iReservationService.save(reservationVo4);
//		
//		List<ReservationVo> reservationVos=new ArrayList<ReservationVo>();
//		reservationVos.addAll(iReservationService.findAll());
//		for (ReservationVo reservationVo5 : reservationVos) {
//			System.out.println(reservationVo5.getId());
//		}
//		List<PropertyVo> propertyVos=iPropertyService.findByCityNameCity("toto");
//		for (PropertyVo propertyVow : propertyVos) {
//			System.out.println(propertyVow.getCity());
//		}
//		
//		 Map<CityVo, Integer> maps= iCityService.countPropertyByCity();
//		 for (Integer value : maps.values()) {
//			System.out.println(value);
//		}
//		 for (CityVo city : maps.keySet()) {
//			System.out.println(city.getNameCity());
//		}

	}

}