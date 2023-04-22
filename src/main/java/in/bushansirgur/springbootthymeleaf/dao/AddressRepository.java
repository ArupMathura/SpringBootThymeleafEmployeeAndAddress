package in.bushansirgur.springbootthymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.bushansirgur.springbootthymeleaf.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
