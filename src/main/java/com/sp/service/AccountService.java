package com.sp.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sp.entity.Account;
import com.sp.repository.AccountRepository;

@Service
public class AccountService {
	
	@Autowired
	private AccountRepository arp;
	
	public boolean InsertAccDetailService(Account acc) {
		boolean status = false;
		try
		{
			arp.save(acc);
			status = true;
			System.out.println("Insert Succuessfully");
			
		}
		catch(Exception e)
		{
			status = false;
			e.printStackTrace();
			System.out.println("Insert Failed");
		}
		return status;
	
	}
	
	public void updateAccountDetail(int acc_mum, int pin_code)
	
	{
		
		try {
		Optional<Account>  optional=arp.findById(acc_mum);
		Account acc=optional.get();
		acc.setPin_code(pin_code);
		arp.save(acc);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
		public void deleteAccountDetail(int acc_num)
			
			{
				
				try {
					arp.deleteById(acc_num);
				}
				catch(Exception e) {
					e.printStackTrace();
				}
				
			}
		
		public Account getAccountDetail(int acc_num)
		
		{
			
		
			Optional<Account>  optional=arp.findById(acc_num);
			Account acc=optional.get();
			return acc;
		
			
			
		}
	
}
