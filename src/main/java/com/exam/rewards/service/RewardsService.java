package com.exam.rewards.service;


import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.models.Response;
import com.exam.rewards.models.TotalPurchaseCustomerResponse;

import java.util.List;

/**
 * The Interface RewardsService.
 */
public interface RewardsService {
    
    /**
     * Gets the total purchase per id.
     *
     * @param customerId the customer id
     * @return the total purchase per id
     */
    public TotalPurchaseCustomerResponse getTotalPurchasePerId(String customerId);
    
    /**
     * Gets the total rewards.
     *
     * @return the total rewards
     */
    public Response<List<RewardsDetails>> getTotalRewards();
    
    /**
     * Gets the total rewards id.
     *
     * @param customerId the customer id
     * @return the total rewards id
     */
    public Response<List<RewardsDetails>> getTotalRewardsId(String customerId);
}
