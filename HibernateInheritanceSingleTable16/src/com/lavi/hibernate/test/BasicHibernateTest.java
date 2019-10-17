package com.lavi.hibernate.test;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.lavi.hibernate.model.FourWheeler;
import com.lavi.hibernate.model.TwoWheeler;
import com.lavi.hibernate.model.Vehicle;
import com.lavi.hibernate.util.HibernateUtil;
/**
 * @author LaVi Technologies
 * 
 */
public class BasicHibernateTest {
public static void main(String[] args) {
		Session session = HibernateUtil.getSession();
		Transaction tx = session.beginTransaction();
		try {
			Vehicle vehicle = new Vehicle();
			vehicle.setVehicleName("VEHICLE");
			vehicle.setFueltype("DieselorPetrol");
			
			session.save(vehicle);
			
			TwoWheeler bike = new TwoWheeler();
			bike.setVehicleName("Bike");
			bike.setStreeingHandle("Bike has Handle steering");
			bike.setFueltype("Petrol");
			session.save(bike);
			
			FourWheeler car = new FourWheeler();
			car.setVehicleName("Car");
			car.setSteeringWheel("Car Streeing Wheel");
			car.setFueltype("Diesel");
						
			session.save(car);
			tx.commit();
			session.close();
			System.out.println("Vehical Details Inserted Successfully");
		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		}
	}
}
