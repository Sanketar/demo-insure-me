package com.project.staragile.insureme;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
	
	@Autowired
	PolicyRepository policyRepository;
	
	
	public Policy CreatePolicy() {
		Policy policy = generateDummyPolicy();
		return policyRepository.save(policy);		
	}
	
	public Policy generateDummyPolicy() {
		return new Policy(1, "Sanket", "Individual" , 10000, "22-Oct-2011", "10-Oct-2021");
	}

	public Policy registerPolicy(Policy policy) {
		// TODO Auto-generated method stub
		return policyRepository.save(policy);
	}

	public Policy getPolicyDetails(int policyId) {
		// TODO Auto-generated method stub
		return policyRepository.findById(policyId).get();
	}
	
	public void deletePolicy(int policyId) {
		// TODO Auto-generated method stub
		policyRepository.deleteById(policyId);
	}

	public List<Policy> viewPolicy(int policyId) {
		// TODO Auto-generated method stub
		return policyRepository.findAll();
	}

	public Policy updatePolicy(int policyId, Policy policyDetails) {
		// TODO Auto-generated method stub
		
		Policy policy = policyRepository.findById(policyId).get();
		policy.setPolicyPrice(policyDetails.getPolicyPrice());
		policy.setPolicyStartDate(policyDetails.getPolicyStartDate()); 
		policy.setPolicyEndDate(policyDetails.getPolicyEndDate());
		policy.setPolicyHolderName(policyDetails.getPolicyHolderName());
				
		return policyRepository.save(policy);
	}

	public Short searchPolicy() {
		// TODO Auto-generated method stub
		return null;
	}

}
