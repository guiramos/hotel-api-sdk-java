/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hotelbeds.hotelapimodel.auto.model.RateDiscount;
import com.hotelbeds.hotelapimodel.auto.model.RateSupplement;
import java.util.List;

import lombok.ToString;
import lombok.NoArgsConstructor;
import lombok.Data;

@JsonInclude(Include.NON_NULL)
@ToString
@NoArgsConstructor
@Data
public class RateBreakDown {

	private List<RateDiscount> rateDiscounts;
	private List<RateSupplement> rateSupplements;


}