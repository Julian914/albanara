package kosta.albanara.mapper;

import kosta.albanara.model.Employees;
import kosta.albanara.model.MarkerLocation;

public interface MarkerLocationMapper {
	int insertMarkerLocation(MarkerLocation markerLocation);
	int existMarkerLocation(String road_address);
	MarkerLocation sessionAddress(String address);	
}
