package service_model;

import java.sql.Date;
import java.util.List;

public class ServiceDAOsvc {
	private ServiceDAO_interface dao=null;

	public ServiceDAOsvc() {
		dao=new ServiceDAO();
	}
	public ServiceVO addservice(String servno,String servclassno,String servname,String servdiscribe,
			Date servupdate,Integer status){
		ServiceVO serviceVO = new ServiceVO();
		serviceVO.setServno(servno);
		serviceVO.setServclassno(servclassno);
		serviceVO.setServname(servname);
		serviceVO.setServdiscribe(servdiscribe);
		serviceVO.setServupdate(servupdate);
		serviceVO.setStatus(status);
		dao.insert(serviceVO);
		return serviceVO;
	}
	public ServiceVO updateservice(String servno,String servclassno,String servname,String servdiscribe,
			Date servupdate,Integer status) {

		ServiceVO ServiceVO = new ServiceVO();

		ServiceVO.setServno(servno);
		ServiceVO.setServclassno(servclassno);
		ServiceVO.setServname(servname);
		ServiceVO.setServdiscribe(servdiscribe);
		ServiceVO.setServupdate(servupdate);
		ServiceVO.setStatus(status);
		
		dao.update(ServiceVO);

		return dao.getOne(servno);
	}
	public List<ServiceVO> getAll(){
		return dao.getAll();
	}
}
