package com.whatsup.repositories;

import com.whatsup.models.Location;
import com.whatsup.models.Vendor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mosesfranco on 7/6/17
 * Codeup
 * Pinnacles
 */
@Repository
public interface LocationsRepository extends CrudRepository<Location, Long> {
	@Query(
		value = "SELECT *  FROM locations WHERE st_within(location, st_envelope(linestring(point(:lon-:dist/abs(cos(radians(:lat))*69), :lat-(:dist/69)), point(:lon+:dist/abs(cos(radians(:lat))*69), :lat+(:dist/69))))) ORDER BY st_distance(point(:lon, :lat), location)",
		nativeQuery = true
	)
	List<Location> getLocationsMap(@Param("lon") double lon, @Param("lat") double lat, @Param("dist")double dist);

	List<Location> getLocationsByVendor(Vendor vendor);

}
