package serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import service.EventService;
import constants.SqlCommands;
import constants.PhotoTypeEnum;
import entity.Event;
import entity.Photograph;
import exception.YearbookException;

public class EventImpl extends ParentAbstract implements EventService{
	
	public void addEvent(Event event, List<Photograph> photoList) throws YearbookException{
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			stmt.execute(SqlCommands.ADD_EVENT_TABLE);
			
			String query = SqlCommands.ADD_EVENT;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, event.getName());
			pstmt.setString(2, event.getDate());
			pstmt.setString(3, event.getUrl());
			pstmt.setString(4, event.getDescription());
			pstmt.executeUpdate();
			
			long eventId = -1;
			ResultSet rs = pstmt.getGeneratedKeys();
            if(rs != null && rs.next()){
            	eventId = rs.getLong(1);
            }
            /*
            if(eventId != -1){
            	PhotographImpl photoDao = new PhotographImpl();
    			for(int index=0; index<photoList.size(); index++){
    				Photograph photo = photoList.get(index);
    				photo.setType(PhotoTypeEnum.EVENT.toString());
    				photo.setTypeId(eventId);
    				photoDao.addPhoto(details);
    			}
            }	*/		
						
			con.commit();
		}catch (SQLException e) {
			if(e.getMessage().toUpperCase().contains("UNIQUE INDEX OR PRIMARY KEY VIOLATION:")) {
				   throw new YearbookException("Duplicate Event ");
				} 
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(con!=null){
				try{
					stmt.close();
					pstmt.close();
					con.close();
					con=null;
					stmt = null;
					pstmt = null;
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
	}

	
	public void deleteEvent(Event event) throws YearbookException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			stmt.execute(SqlCommands.ADD_EVENT_TABLE);
			
			int result = 0;
			PhotographImpl photoDao = new PhotographImpl();
    		Photograph photo =new Photograph();
			photo.setType(PhotoTypeEnum.EVENT.toString());
			photo.setTypeId(event.getEventId());
			//result += photoDao.deletePhotos(photo, con);	
			

			String query = SqlCommands.DELETE_EVENT;
			pstmt = con.prepareStatement(query);
			pstmt.setLong(1, event.getEventId());
			result = pstmt.executeUpdate();
			if(result == 0){
				throw new YearbookException("Incorrect details for event delete..");
			}
			con.commit();
		}catch(YearbookException e){
			throw e;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(con!=null){
				try{
					stmt.close();
					pstmt.close();
					con.close();
					con=null;
					stmt = null;
					pstmt = null;
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
		
	}

	
	public void updateEvent(Event event, List<Photograph> photoList) throws YearbookException {
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		try{
			con = getConnection();
			con.setAutoCommit(false);
			
			stmt = con.createStatement();
			stmt.execute(SqlCommands.ADD_EVENT_TABLE);
			
			String query = SqlCommands.UPDATE_EVENT;
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, event.getName());
			pstmt.setString(2, event.getDate());
			pstmt.setString(3, event.getUrl());
			pstmt.setString(4, event.getDescription());
			pstmt.setLong(5, event.getEventId());
			int result = pstmt.executeUpdate();     

        	PhotographImpl photoDao = new PhotographImpl();
        	Photograph photo = new Photograph();
        	photo.setType(PhotoTypeEnum.EVENT.toString());
        	photo.setTypeId(event.getEventId());
           // photoDao.deletePhotos(photo, con);
            
            for(int index=0; index<photoList.size(); index++){
				photo = photoList.get(index);
				photo.setType(PhotoTypeEnum.EVENT.toString());
				photo.setTypeId(event.getEventId());
				//photoDao.addPhoto(photo, con);
				result++;
			}			
            if(result == 0){
				throw new YearbookException("Incorrect details for event update..");
			}
			con.commit();
		}catch(YearbookException e){
			throw e;
		}catch(Exception e){
			System.out.println(e.getMessage());
		}finally{
			if(con!=null){
				try{
					stmt.close();
					pstmt.close();
					con.close();
					con=null;
					stmt = null;
					pstmt = null;
				}catch(Exception e){
					System.out.println(e);
				}
			}
		}
		
	}
}
