package com.enfernuz.quik.lua.rpc.events.api.structures;

import com.google.common.base.MoreObjects;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.NonFinal;

import java.util.Objects;

@Value
public class AllTrade {

    long tradeNum;
    int flags;
    String price;
    int qty;
    String value;
    String accruedInt;
    String yield;
    String settleCode;
    String repoRate;
    String repoValue;
    String repo2Value;
    String repoTerm;
    String secCode;
    String classCode;
    DateTimeEntry dateTime;
    int period;
    String openInterest;
    String exchangeCode;

    private @NonFinal transient int hashCode;
    private @NonFinal transient String asString;

    @Builder
    private AllTrade(final long tradeNum,
                    final int flags,
                    final String price,
                    final int qty,
                    final String value,
                    final String accruedInt,
                    final String yield,
                    final String settleCode,
                    final String repoRate,
                    final String repoValue,
                    final String repo2Value,
                    final String repoTerm,
                    final String secCode,
                    final String classCode,
                    final DateTimeEntry dateTime,
                    final int period,
                    final String openInterest,
                    final String exchangeCode) {

        this.tradeNum = tradeNum;
        this.flags = flags;
        this.price = price;
        this.qty = qty;
        this.value = value;
        this.accruedInt = accruedInt;
        this.yield = yield;
        this.settleCode = settleCode;
        this.repoRate = repoRate;
        this.repoValue = repoValue;
        this.repo2Value = repo2Value;
        this.repoTerm = repoTerm;
        this.secCode = secCode;
        this.classCode = classCode;
        this.dateTime = dateTime;
        this.period = period;
        this.openInterest = openInterest;
        this.exchangeCode = exchangeCode;
    }

    @Override
    public boolean equals(final Object o) {

        if (o == this) {
            return true;
        } else if ( !(o instanceof AllTrade) ) {
            return false;
        } else {
            final AllTrade allTrade = (AllTrade) o;
            return tradeNum == allTrade.tradeNum &&
                    flags == allTrade.flags &&
                    qty == allTrade.qty &&
                    period == allTrade.period &&
                    Objects.equals(price, allTrade.price) &&
                    Objects.equals(value, allTrade.value) &&
                    Objects.equals(accruedInt, allTrade.accruedInt) &&
                    Objects.equals(yield, allTrade.yield) &&
                    Objects.equals(settleCode, allTrade.settleCode) &&
                    Objects.equals(repoRate, allTrade.repoRate) &&
                    Objects.equals(repoValue, allTrade.repoValue) &&
                    Objects.equals(repo2Value, allTrade.repo2Value) &&
                    Objects.equals(repoTerm, allTrade.repoTerm) &&
                    Objects.equals(secCode, allTrade.secCode) &&
                    Objects.equals(classCode, allTrade.classCode) &&
                    Objects.equals(dateTime, allTrade.dateTime) &&
                    Objects.equals(openInterest, allTrade.openInterest) &&
                    Objects.equals(exchangeCode, allTrade.exchangeCode);
        }
    }

    @Override
    public int hashCode() {

        if (hashCode == 0) {
            hashCode =
                    Objects.hash(
                            tradeNum,
                            flags,
                            price,
                            qty,
                            value,
                            accruedInt,
                            yield,
                            settleCode,
                            repoRate,
                            repoValue,
                            repo2Value,
                            repoTerm,
                            secCode,
                            classCode,
                            dateTime,
                            period,
                            openInterest,
                            exchangeCode
                    );
        }

        return hashCode;
    }

    @Override
    public String toString() {

        if (asString == null) {
            asString = MoreObjects.toStringHelper(this)
                    .add("tradeNum", tradeNum)
                    .add("flags", flags)
                    .add("price", price)
                    .add("qty", qty)
                    .add("value", value)
                    .add("accruedInt", accruedInt)
                    .add("yield", yield)
                    .add("settleCode", settleCode)
                    .add("repoRate", repoRate)
                    .add("repoValue", repoValue)
                    .add("repo2Value", repo2Value)
                    .add("repoTerm", repoTerm)
                    .add("secCode", secCode)
                    .add("classCode", classCode)
                    .add("dateTime", dateTime)
                    .add("period", period)
                    .add("openInterest", openInterest)
                    .add("exchangeCode", exchangeCode)
                    .toString();
        }

        return asString;
    }
}
