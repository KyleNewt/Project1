package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookingsDao {
	public List<Bookings> getAllBookings() {
		PreparedStatement ps = null;
		Bookings myBookings = null;
		List<Bookings> bookingsList = new ArrayList<>();
		
		try(Connection conn = ConnectionUtil.getConnection()) {
			String sql = "SELECT * FROM BOOKINGS";
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
                int roomId = rs.getInt("room_id");
                String bookingStartDate = rs.getString("booking_start_date");
                String bookingEndDate  = rs.getString("booking_end_date");
                String email = rs.getString("email");
                double totalPrice = rs.getDouble("total_price");
                String status = rs.getString("status");
				
                myBookings = new Bookings(int roomId, String bookingStartDate, String bookingEndDate, 
                String email, double totalPrice, String status);
				bookingsList.add(myBookings);
			}
			
			rs.close();
			ps.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return bookingsList;
	}
}
