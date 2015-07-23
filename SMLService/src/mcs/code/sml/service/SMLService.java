package mcs.code.sml.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;

import mcs.code.sml.controller.Doctors;
import mcs.code.sml.entity.EntDoctors;

@XmlSeeAlso({mcs.code.sml.entity.EntDoctors.class })
// @XmlSeeAlso({it.codegen.tbx.sun.service.AccommodationType.class,it.codegen.tbx.sun.service.TrnCountry.class,it.codegen.tbx.sun.service.TrnUser.class,it.codegen.tbx.sun.service.TrnRequest.class,it.codegen.tbx.sun.service.TrnContract.class,com.trn.sun.entity.TrnHotel.class,it.codegen.tbx.sun.service.TrnHotelBranch.class})
// @XmlSeeAlso({it.codegen.tbx.sun.service.HotelAccomodation.class})
@WebService(name = "SMLService", targetNamespace = "http://service.sml.code.mcs")
public class SMLService
{
	public void SMLService() {}

	@PostConstruct
	public void initJAXWs()
	{
		System.out.println("init start");
		init();
		System.out.println("init Called");
	}

	@PreDestroy()
	public void destroy()
	{
		//TODO
	}

	public void init()
	{
		//TODO
	}

	@WebMethod
	public List<String> getDoctorsList()
	{
		Doctors docObj = new Doctors();
		List<EntDoctors> doctors = docObj.getDoctors();
		
		List<String> doctorsList = new ArrayList<String>();
		if( doctors != null && doctors.size() > 0 ){
			for(EntDoctors currentDoctor : doctors){
				doctorsList.add( currentDoctor.getfName() );
			}
		}
		doctorsList.add( "K.M. Perera" );
		doctorsList.add( "P.L. Gunarathna" );
		doctorsList.add( "W.D. Senevirathna" );
		return doctorsList;
	}


}
