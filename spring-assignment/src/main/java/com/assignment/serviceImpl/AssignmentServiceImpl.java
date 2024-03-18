package com.assignment.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assignment.dao.AssignmentDao;
import com.assignment.model.DataModel;
import com.assignment.service.AssignmentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AssignmentServiceImpl implements AssignmentService{
	
	@Autowired
	AssignmentDao dataDao;

	@Override
	public Flux<DataModel> getAllData() {
		// TODO Auto-generated method stub
		return dataDao.findAll();
	}

	@Override
	public Mono<DataModel> saveData(DataModel data) {
		// TODO Auto-generated method stub
		return dataDao.save(data);
	}

	@Override
	public Mono<ResponseEntity<DataModel>> updateData(long id, DataModel product) {
		// TODO Auto-generated method stub
		 return dataDao.findById(id)
				.flatMap(existProduct->{
					existProduct.setName(product.getName());
					existProduct.setNrc(product.getNrc());
					existProduct.setBirthday(product.getBirthday());
					existProduct.setInterest(product.getInterest());
					existProduct.setPhone(product.getPhone());
					existProduct.setEmail(product.getEmail());
					existProduct.setTownship(product.getTownship());
					existProduct.setAddress(product.getAddress());
					return dataDao.save(existProduct);
				}).map(updateProduct->new ResponseEntity<>(updateProduct,HttpStatus.OK))
				.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@Override
	public Mono<ResponseEntity<Void>> deleteData(long id) {
		return dataDao.findById(id)
				.flatMap(existProduct->dataDao.delete(existProduct)
						.then(Mono.just(new ResponseEntity<Void>(HttpStatus.OK)))
						)
						.defaultIfEmpty(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

}
