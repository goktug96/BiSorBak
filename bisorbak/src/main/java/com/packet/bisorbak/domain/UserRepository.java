package com.packet.bisorbak.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUserName(String username);
    /*public interface CarRepository extends PagingAndSortingRepository<Car, Long> {}*/
    //List<Car> findByBrand(String brand);
    //List<Car> findByBrandAndModel(String brand, String model);
    //List<Car> findByBrandOrderByYearAsc(String brand);
    /*@Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrand(String brand);*/
}
