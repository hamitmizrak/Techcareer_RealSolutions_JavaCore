package com.hamitmizrak._02_week;

import java.util.StringTokenizer;

public class _05_2_StringBuilderBufferTokenizer {

    public static void main(String[] args) {

        String value1="jsp,",value2="jsf,",value3="servlet,",value4="jstl";

        // 1- (+)
        String result= value1+value2+value3+value4;
        System.out.println(result);

        // 2- Concat
        String concatData=value1.concat(value2).concat(value3).concat(value4);
        System.out.println(concatData);

        // 3- StringBuffer
        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append(value1).append(value2).append(value3).append(value4);
        String bufferToString = stringBuffer.toString();
        System.out.println(bufferToString);

        // 4- StringBuilder
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(value1).append(value2).append(value3).append(value4);
        String builderToString = stringBuilder.toString();
        System.out.println(builderToString);

        // 5- StringTokenizer
        String data="java,jsp+jsf_servlet~spring framework";
        //StringTokenizer stringTokenizer = new StringTokenizer(data); // Default: Boşluğa göredir
        StringTokenizer stringTokenizer = new StringTokenizer(data,",+_~*"); // Default: Boşluğa göredir
        while (stringTokenizer.hasMoreTokens()) {
            System.out.println(stringTokenizer.nextToken());
        }

    }
}
