/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2014-2016 Marc de Verdelhan & respective authors (see AUTHORS)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.ctp.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.joda.time.DateTime;
import org.joda.time.Period;

import au.com.bytecode.opencsv.CSVReader;
import au.com.bytecode.opencsv.CSVWriter;
import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.Tick;
import eu.verdelhan.ta4j.TimeSeries;

/**
 * This class build a Ta4j time series from a CSV file containing ticks.
 */
public class CsvTicksLoader {
	 private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    private static final String FILE_PATH= "E:\\rb1610.csv";

    /**
     * @return a time series from Apple Inc. ticks.
     */
    public static TimeSeries loadAppleIncSeries() {

//        InputStream stream = CsvTicksLoader.class.getClassLoader().getResourceAsStream("appleinc_ticks_from_20130101_usd.csv");
        InputStream stream = null;
		try {
			stream = new FileInputStream(new File(FILE_PATH));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

        List<Tick> ticks = new ArrayList<Tick>();

        CSVReader csvReader = new CSVReader(new InputStreamReader(stream, Charset.forName("UTF-8")), ',', '"', 1);
        try {
            String[] line;
            while ((line = csvReader.readNext()) != null) {
            	DateTime date = new DateTime(DATE_FORMAT.parse(line[0]));
                double open = Double.parseDouble(line[1]);
                double high = Double.parseDouble(line[2]);
                double low = Double.parseDouble(line[3]);
                double close = Double.parseDouble(line[4]);
                double volume = Double.parseDouble(line[5]);
                ticks.add(new Tick(date, open, high, low, close, volume));
            }
        } catch (IOException ioe) {
            Logger.getLogger(CsvTicksLoader.class.getName()).log(Level.SEVERE, "Unable to load ticks from CSV", ioe);
        } catch (NumberFormatException nfe) {
            Logger.getLogger(CsvTicksLoader.class.getName()).log(Level.SEVERE, "Error while parsing value", nfe);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return new TimeSeries("rb1610_ticks", ticks);
    }
   
    /**
     * @return a time series from Apple Inc. ticks.
     */
    public static void writeAppleIncSeries(Tick tick) {
		try {
			CSVWriter writer = new CSVWriter(new FileWriter(new File(FILE_PATH),true),',',CSVWriter.NO_QUOTE_CHARACTER);
			String[] tk = new String[6];
	    	tk[0]= DATE_FORMAT.format(tick.getEndTime().toDate());
	    	tk[1]=tick.getOpenPrice()+"";
	    	tk[2]=tick.getMaxPrice()+"";
	    	tk[3]=tick.getMinPrice()+"";
	    	tk[4]=tick.getClosePrice()+"";
	    	tk[5]=tick.getVolume()+"";
	    	writer.writeNext(tk);
	    	writer.close();  
		} catch (IOException e) {
			e.printStackTrace();
		}  
    	
    }
    
    public static void main(String args[]) {
       /* TimeSeries series = CsvTicksLoader.loadAppleIncSeries();

        System.out.println("Series: " + series.getName() + " (" + series.getSeriesPeriodDescription() + ")");
        System.out.println("Number of ticks: " + series.getTickCount());
        System.out.println("First tick: \n"
                + "\tVolume: " + series.getTick(0).getVolume() + "\n"
                + "\tOpen price: " + series.getTick(0).getOpenPrice()+ "\n"
                + "\tClose price: " + series.getTick(0).getClosePrice());*/
    	CsvTicksLoader.writeAppleIncSeries(new Tick(Period.days(1),new DateTime(),Decimal.valueOf(1),Decimal.valueOf(2),Decimal.valueOf(3),Decimal.valueOf(5), Decimal.valueOf(5)));
    }
}
