package service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.data.ParkRepository;
import com.data.Request;
import com.data.Response;
import com.service.ServiceImpl;


public class ServiceImplTest {
	@Test
	void testGetStatus(Request request) {
        ServiceImpl serviceImpl = new ServiceImpl(mock(ParkRepository.class));
        Response response = new Response();
        response.setResult("Status");
        when(serviceImpl.getStatus(request)).thenReturn(response);
        assertEquals(serviceImpl.getStatus(request).getResult(), "Status");
	}
}
