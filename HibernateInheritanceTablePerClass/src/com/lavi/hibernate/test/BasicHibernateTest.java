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
			Vehicle vehical = new Vehicle();
			vehical.setVehicalName("VEHICLE");
			vehical.setFuelType("VEHICLE_FUEL");

			TwoWheeler bike = new TwoWheeler();
			bike.setVehicalName("Bike");
			bike.setStreeingHandle("Bike Strrring Handle");
			bike.setFuelType("Bike_fuel");

			FourWheeler car = new FourWheeler();
			car.setVehicalName("Car");
			car.setSteeringWheel("Car Streeing Wheel");
			car.setFuelType("car_Fuel");

			session.save(vehical);
			session.save(bike);
			session.save(car);

			tx.commit();
			session.close();

			System.out.println("Vehical Details Inserted Successfully");

		} catch (HibernateException ex) {
			System.err.println(".HibernateException." + ex.getClass().getName()
					+ " -- " + ex.getMessage());
			tx.rollback();
		}
	}
}
