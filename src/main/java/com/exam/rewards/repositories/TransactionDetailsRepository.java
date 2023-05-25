package com.exam.rewards.repositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exam.rewards.entities.RewardsDetails;
import com.exam.rewards.entities.TransactionDetails;

/**
 * The Interface TransactionDetailsRepository.
 */

public interface TransactionDetailsRepository extends JpaRepository<TransactionDetails, Long> {

	/**
	 * Find by customer id.
	 *
	 * @param customerId the customer id
	 * @return the list
	 */
	List<TransactionDetails> findByCustomerId(String customerId);

	/**
	 * Gets the sum of rewards by id.
	 *
	 * @param customerId the customer id
	 * @return the sum of rewards by id
	 */
	@Query("select SUM(e.purchaseAmount) from TransactionDetails e where e.customerId = :customerId")
	BigDecimal getSumOfRewardsById(@Param("customerId") String customerId);

	/**
	 * Gets the all customers with rewards.
	 * @param dateBeforeThreeMonths 
	 *
	 * @return the all customers with rewards
	 */
	@Query("select new com.exam.rewards.entities.RewardsDetails(e.customerId, e.customerName, SUM(e.purchaseAmount), month(e.purchaseDate)) from TransactionDetails e where e.purchaseDate >= :dateBeforeThreeMonths group by e.customerId, month(e.purchaseDate)")
	List<RewardsDetails> getAllCustomersWithRewards(@Param("dateBeforeThreeMonths") LocalDate dateBeforeThreeMonths);

	/**
	 * Gets the reward by customer id.
	 *
	 * @param customerId the customer id
	 * @return the reward by customer id
	 */
	@Query("select new com.exam.rewards.entities.RewardsDetails(e.customerId, e.customerName, SUM(e.purchaseAmount),month(e.purchaseDate)) from TransactionDetails e where e.customerId = :customerId and e.purchaseDate >= :dateBeforeThreeMonths group by e.customerId, month(e.purchaseDate)")
	List<RewardsDetails> getRewardByCustomerId(@Param("customerId") String customerId, @Param("dateBeforeThreeMonths") LocalDate dateBeforeThreeMonths);
}
