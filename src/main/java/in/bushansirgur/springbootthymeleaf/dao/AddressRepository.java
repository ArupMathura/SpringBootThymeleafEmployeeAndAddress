package in.bushansirgur.springbootthymeleaf.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bushansirgur.springbootthymeleaf.entity.Address;
import in.bushansirgur.springbootthymeleaf.entity.Employee;

public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByEmployee(Employee employee);
}
