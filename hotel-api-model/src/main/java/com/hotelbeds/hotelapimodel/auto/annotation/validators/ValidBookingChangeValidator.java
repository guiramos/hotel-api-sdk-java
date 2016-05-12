/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.annotation.validators;

/*
 * #%L
 * HotelAPI Model
 * %%
 * Copyright (C) 2015 - 2016 HOTELBEDS TECHNOLOGY, S.L.U.
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 2.1 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 * 
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-2.1.html>.
 * #L%
 */


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.hotelbeds.hotelapimodel.auto.messages.BookingChangeRQ;
import com.hotelbeds.hotelapimodel.auto.model.BookingChangeRoom;
import com.hotelbeds.hotelapimodel.auto.util.AssignUtils;

public class ValidBookingChangeValidator implements ConstraintValidator<ValidBookingChange, BookingChangeRQ> {
    @Override
    public void initialize(ValidBookingChange constraintAnnotation) {
        // empty method

    }

    @Override
    public boolean isValid(BookingChangeRQ value, ConstraintValidatorContext context) {
        boolean result = true;
        context.disableDefaultConstraintViolation();
        result = validRoomIdOnThePaxes(value, context);
        return result;
    }

    private boolean validRoomIdOnThePaxes(final BookingChangeRQ bookingChangeRQ, final ConstraintValidatorContext context) {
        boolean valid = true;
        if (!AssignUtils.isEmpty(bookingChangeRQ.getRooms())) {
            for (BookingChangeRoom room : bookingChangeRQ.getRooms()) {
                if (!AssignUtils.isEmpty(room.getPaxes())) {
                    valid = !(room.getPaxes().stream().anyMatch(pax -> {
                        return pax.getRoomId() == null;
                    }));
                    if (!valid) {
                        context.buildConstraintViolationWithTemplate("{com.hotelbeds.BookingChangeFilter.allPaxesMustContainRoomId.message}")
                            .addConstraintViolation();
                    }
                }
            }
        }
        return valid;
    }
}