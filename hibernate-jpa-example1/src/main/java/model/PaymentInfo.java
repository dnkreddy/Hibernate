package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the PAYMENT_INFO database table.
 * 
 */
@Entity
@Table(name="PAYMENT_INFO")
@NamedQuery(name="PaymentInfo.findAll", query="SELECT p FROM PaymentInfo p")
public class PaymentInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long pid;

	@Column(name="PAT_AMNT")
	private BigDecimal patAmnt;

	@Temporal(TemporalType.DATE)
	@Column(name="PAY_DATE")
	private Date payDate;

	public PaymentInfo() {
	}

	public long getPid() {
		return this.pid;
	}

	public void setPid(long pid) {
		this.pid = pid;
	}

	public BigDecimal getPatAmnt() {
		return this.patAmnt;
	}

	public void setPatAmnt(BigDecimal patAmnt) {
		this.patAmnt = patAmnt;
	}

	public Date getPayDate() {
		return this.payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}

}