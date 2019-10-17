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
			vehical.setVehicalName("VEHICLE_NAME");
			vehical.setFuelType("VEHICLE_FUEL");

			TwoWheeler bike = new TwoWheeler();
			bike.setVehicalName("Bike");
			bike.setStreeingHandle("Bike Strrring Handle");
			bike.setFuelType("Bike_fuel");

			FourWheeler car = new FourWheeler();
			car.setVehicalName("Car");
			car.setSteeringWheel("Car Streeing Wheel");
			car.setFuelType("Car_fuel");

			session.save(vehical);
			session.save(bike);
			session.save(car);

			
			//FourWheeler fw = session.load(FourWheeler.class, 3);
			//System.out.println(fw.getVehicalName());
			
			tx.commit();
			session.close();

			System.out.println("Vehical Details Inserted Successfully");

			// SELECT * FROM VEHICAL JOIN TWO_WHEELER ON
			// VEHICAL.VEHICAL_ID=TWO_WHEELER.VEHICAL_ID;

		} catch (HibernateException ex) {
			ex.printStackTrace();
			tx.rollback();
		}
	}
}
