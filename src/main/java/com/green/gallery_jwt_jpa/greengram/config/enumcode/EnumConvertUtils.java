package com.green.gallery_jwt_jpa.greengram.config.enumcode;


import io.micrometer.common.util.StringUtils;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.EnumSet;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class EnumConvertUtils {
    //String to Enum

    //리턴 타입이 Enum이여야 하고 EnumMapperType을 상속받은 Enum 이여야 한다.
    //EnumClass는 Enum타입이여야 한다.
    public static <E extends Enum<E> & EnumMapperType> E ofCode(Class<E> enumClass, String code) {
         if(StringUtils.isEmpty(code)) {
             return null;
         }
         //Enum에 있는 값중 매개변수 code와 같은  값을 찾아서 리턴하기 위함
         return EnumSet.allOf(enumClass).stream()
                 .filter(item -> item.getCode().equals(code))
                 .findFirst().orElse(null);
    }

    //Enum to String(Code값)

    public static <E extends Enum<E> & EnumMapperType> String toCode(E enumItem){
        if(enumItem == null) {return null;}
        return enumItem.getCode();
    }


}
