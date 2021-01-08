package mackito_example;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


import model.Customer;
import model.Item;


@ExtendWith(MockitoExtension.class)
public class CustomerTest {
		
	Customer customer = new Customer();
	
	@BeforeAll
	public void setup() {
		customer = new Customer();
		customer.setName("Bob");
		
		List<Item> listOfItems=new ArrayList<Item>();
		Item item1=Mockito.mock(Item.class);
		Item item2=Mockito.mock(Item.class);
		Item item3=Mockito.mock(Item.class);
		
		listOfItems.add(item1);
		listOfItems.add(item2);
		listOfItems.add(item3);
		
		customer.setListOfItems(listOfItems);
		when(item1.getName()).thenReturn("Rice");
		when(item2.getName()).thenReturn("Tea");
		when(item3.getName()).thenReturn("Wheat");
		when(item1.getPrice("Rice")).thenReturn(100);
		when(item2.getPrice("Tea")).thenReturn(200);
		when(item3.getPrice("Wheat")).thenReturn(300);
		
	}

	@Test
	public void test_Customer_CalculateBill()
	{
		int billAmount=customer.calculateBill();
		assertEquals(600, billAmount);
	}
}
