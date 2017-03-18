package service_model;

import java.util.List;

public interface ServiceDAO_interface {
	public void insert(ServiceVO serviceVO);
	public void update(ServiceVO serviceVO);
	public void delete(String servno);
	public ServiceVO getOne(String servno );
	public List<ServiceVO> getAll();
}
