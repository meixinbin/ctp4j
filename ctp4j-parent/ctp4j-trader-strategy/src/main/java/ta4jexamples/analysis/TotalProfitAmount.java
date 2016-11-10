package ta4jexamples.analysis;

import eu.verdelhan.ta4j.Decimal;
import eu.verdelhan.ta4j.TimeSeries;
import eu.verdelhan.ta4j.Trade;
import eu.verdelhan.ta4j.TradingRecord;
import eu.verdelhan.ta4j.analysis.criteria.AbstractAnalysisCriterion;

public class TotalProfitAmount  extends AbstractAnalysisCriterion{

	@Override
	public double calculate(TimeSeries series, Trade trade) {
		return 0;
	}

	@Override
	public double calculate(TimeSeries series, TradingRecord tradingRecord) {
		double value = 0d;
        for (Trade trade : tradingRecord.getTrades()) {
            value += calculateProfit(series, trade);
        }
        return value;
	}

	@Override
	public boolean betterThan(double criterionValue1, double criterionValue2) {
		return false;
	}
	 private double calculateProfit(TimeSeries series, Trade trade) {
        Decimal profit = Decimal.ZERO;
        if (trade.isClosed()) {
            Decimal exitClosePrice = series.getTick(trade.getExit().getIndex()).getClosePrice();
            Decimal entryClosePrice = series.getTick(trade.getEntry().getIndex()).getClosePrice();

            if (trade.getEntry().isBuy()) {
                profit = exitClosePrice.minus(entryClosePrice);
            } else {
                profit = entryClosePrice.minus(exitClosePrice);
            }
        }
        return profit.toDouble();
    }
}
