/**
 * Autogenerated code by SdkModelGenerator.
 * Do not edit. Any modification on this file will be removed automatically after project build
 *
 */
package com.hotelbeds.hotelapimodel.auto.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

import com.hotelbeds.hotelapimodel.auto.common.SimpleTypes.SiNo;
import com.hotelbeds.hotelapimodel.auto.common.SimpleTypes.YesNo;

public final class AssignUtils {
    public static final String DEFAULT_DATE_FORMAT = "yyyyMMdd";
    public static final DateTimeFormatter DEFAULT_DATE_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_FORMAT);
    public static final String DEFAULT_TIME_FORMAT = "HHmm";
    public static final DateTimeFormatter DEFAULT_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_TIME_FORMAT);
    public static final String DEFAULT_DATE_TIME_FORMAT = DEFAULT_DATE_FORMAT + " " + DEFAULT_TIME_FORMAT;
    public static final DateTimeFormatter DEFAULT_DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern(DEFAULT_DATE_TIME_FORMAT);
    public static final DateTimeFormatter REST_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    public static final String ACE_DATE_FORMAT = "dd/MM/yyyy";
    public static final String ACE_TIME_FORMAT = "HH:mm";
    public static final DateTimeFormatter ACE_DATE_TIME_FORMAT = DateTimeFormatter.ofPattern(ACE_DATE_FORMAT + " " + ACE_TIME_FORMAT);
    private static final int HOUR_SECONDS = 3600;
    private static final int PRICE_NUMBER_OF_DECIMALS = 2;
    private static final int PERCENTAGE_NUMBER_OF_DECIMALS = 2;
    public static final String COMMA_SEPARATOR = ",";

    private AssignUtils() {
    }

    public static Timestamp getTimestamp(final LocalDateTime datetime) {
        return datetime != null ? Timestamp.valueOf(datetime) : null;
    }

    public static Timestamp getTimestamp(final LocalDate date) {
        return date != null ? Timestamp.valueOf(date.atStartOfDay()) : null;
    }

    public static Timestamp getTimestamp(final ZonedDateTime date) {
        return date != null ? Timestamp.from(date.toInstant()) : null;
    }

    public static LocalDate getLocalDate(final Date date) {
        return date != null ? date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate() : null;
    }

    public static LocalTime getLocalTime(final Timestamp timestamp) {
        return timestamp != null ? timestamp.toLocalDateTime().toLocalTime() : null;
    }

    public static ZonedDateTime getZonedDateTime(final Timestamp timestamp) {
        return timestamp != null ? ZonedDateTime.ofInstant(timestamp.toInstant(), ZoneId.systemDefault()) : null;
    }

    public static Date getDate(final LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static Date getDate(final LocalDate localDate) {
        Instant instant = localDate.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }

    public static LocalDateTime getLocalDateTime(final Timestamp timestamp) {
        // empty method
        return timestamp != null ? timestamp.toLocalDateTime() : null;
    }

    public static LocalDateTime getLocalDateTime(Date date) {
        Instant instant = Instant.ofEpochMilli(date.getTime());
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    public static LocalDate getLocalDate(final String date) {
        return getLocalDate(date, DEFAULT_DATE_FORMATTER);
    }

    public static LocalDate getLocalDate(final String date, final DateTimeFormatter formatter) {
        return date != null ? LocalDate.parse(date, formatter) : null;
    }

    public static LocalDateTime getLocalDateTime(final String date) {
        return getLocalDateTime(date, DEFAULT_TIME_FORMATTER);
    }

    public static LocalDateTime getLocalDateTime(final String date, final DateTimeFormatter formatter) {
        return date != null ? LocalDateTime.parse(date, formatter) : null;
    }

    public static LocalDateTime getLocalDateTime(final LocalDate date) {
        return getLocalDateTime(getTimestamp(date));
    }

    public static BigInteger getHourDifference(final ZoneOffset zoneOffset) {
        return zoneOffset != null ? BigInteger.valueOf(Long.valueOf(zoneOffset.get(ChronoField.OFFSET_SECONDS)) / HOUR_SECONDS) : null;
    }

    public static LocalTime getTime(final String time, final DateTimeFormatter formatter) {
        return time != null ? LocalTime.parse(time, formatter) : null;
    }

    public static String getString(final LocalTime time, final DateTimeFormatter formatter) {
        return time != null ? time.format(formatter) : null;
    }

    public static String getString(final LocalDate date, final DateTimeFormatter formatter) {
        return date != null ? date.format(formatter) : null;
    }

    public static String getString(final LocalDateTime dateTime, final DateTimeFormatter formatter) {
        return dateTime != null ? dateTime.format(formatter) : null;
    }

    public static String getString(final LocalDate time) {
        return getString(time, DEFAULT_DATE_FORMATTER);
    }

    public static String getSortedString(final String separator, final List<String> stringList) {
        String result = null;
        if (isNotEmpty(stringList)) {
            result = stringList.stream().sorted().collect(Collectors.joining(separator));
        }
        return result;
    }

    public static ZoneOffset getZoneOffset(final BigDecimal hourDifference) {
        int auxValue = 0;
        if (hourDifference != null) {
            auxValue = hourDifference.intValue();
        }
        return ZoneOffset.ofHours(auxValue);
    }

    public static String getString(final Integer number) {
        return number != null ? number.toString() : null;
    }

    public static String getString(final Float number) {
        return number != null ? number.toString() : null;
    }

    public static String getString(final Double number) {
        return number != null ? number.toString() : null;
    }

    public static String getStringNotEmpty(final String string) {
        return StringUtils.isNotEmpty(string) ? string : null;
    }

    public static String getStringNotBlank(final String string) {
        return StringUtils.isNotBlank(string) ? string : null;
    }

    public static Integer safeInteger(final BigDecimal number) {
        Integer result = null;
        if (number != null) {
            result = number.intValue();
        }
        return result;
    }

    public static Integer safeInteger(final String number) {
        Integer result = null;
        if (StringUtils.isNotEmpty(number)) {
            result = Integer.parseInt(number);
        }
        return result;
    }

    public static BigDecimal safeBigDecimal(final String number, final int newScale) {
        BigDecimal result = null;
        if (StringUtils.isNotEmpty(number)) {
            result = new BigDecimal(number, MathContext.DECIMAL64).setScale(newScale, BigDecimal.ROUND_HALF_EVEN);
        }
        return result;
    }

    public static Double safeDouble(final String number) {
        Double result = null;
        if (StringUtils.isNotEmpty(number)) {
            result = Double.parseDouble(number);
        }
        return result;
    }

    public static Short safeShort(final String number) {
        Short result = null;
        if (StringUtils.isNotEmpty(number)) {
            result = Short.parseShort(number);
        }
        return result;
    }

    public static Boolean safeBoolean(final String stringSY) {
        Boolean result = Boolean.FALSE;
        if (StringUtils.isNotEmpty(stringSY) && (SiNo.S.name().equalsIgnoreCase(stringSY) || YesNo.Y.name().equalsIgnoreCase(stringSY))) {
            result = Boolean.TRUE;
        }
        return result;
    }

    public static BigDecimal getBigDecimalForPriceTag(final Double amount) {
        if (amount == null) {
            return null;
        }
        return new BigDecimal(amount).setScale(PRICE_NUMBER_OF_DECIMALS, BigDecimal.ROUND_HALF_EVEN);
    }

    public static BigDecimal getBigDecimalForPercentageTag(String amount) {
        return safeBigDecimal(amount, PERCENTAGE_NUMBER_OF_DECIMALS);
    }

    public static BigDecimal getBigDecimalForPercentageTag(Double amount) {
        if (amount == null) {
            return null;
        }
        return new BigDecimal(amount).setScale(PERCENTAGE_NUMBER_OF_DECIMALS, BigDecimal.ROUND_HALF_EVEN);
    }

    public static BigDecimal getBigDecimalForPercentageTag(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return amount.setScale(PERCENTAGE_NUMBER_OF_DECIMALS, BigDecimal.ROUND_HALF_EVEN);
    }

    public static BigDecimal getBigDecimalForPriceTag(BigDecimal amount) {
        if (amount == null) {
            return null;
        }
        return amount.setScale(PRICE_NUMBER_OF_DECIMALS, BigDecimal.ROUND_HALF_EVEN);
    }

    public static BigDecimal getBigDecimalForPriceTag(String amount) {
        return safeBigDecimal(amount, PRICE_NUMBER_OF_DECIMALS);
    }

    public static BigDecimal getBigDecimalForPriceTag(float amount) {
        return getBigDecimalForPriceTag(new BigDecimal(amount));
    }

    public static BigDecimal getBigDecimalForPercentageTag(float amount) {
        return getBigDecimalForPercentageTag(new BigDecimal(amount));
    }

    /**
     * Truncate a String to the given length with no warnings
     * or error raised if it is bigger.
     *
     * @param value String to be truncated
     * @param length Maximum length of string
     * @return Returns value if value is null or value.length() is less or equal to than length, otherwise a String representing
     *         value truncated to length.
     */
    public static String truncate(String value, int length) {
        String truncatedString = "";
        if (value != null && value.length() > length) {
            truncatedString = value.substring(0, length);
        }
        return truncatedString;
    }

    public static boolean isEmpty(Collection<?> collection) {
        return collection == null || collection.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collection) {
        return !isEmpty(collection);
    }
}