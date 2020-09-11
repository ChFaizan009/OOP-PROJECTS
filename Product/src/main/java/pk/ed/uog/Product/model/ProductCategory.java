package pk.ed.uog.Product.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TBLPRODUCTCATERGORY")
public class ProductCategory
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long PRODUCTCATERGORY_ID;

	@Column(name = "PRODUCTCATERGORY_NAME")
	private String PRODUCTCATERGORY_NAME;

	@Column(name = "PRODUCTCATERGORY_DESC")
	private String PRODUCTCATERGORY_DESC;

	@Column(name = "ISACTIVE")
	private String ISACTIVE;

	@Column(name = "MODIFIED_BY")
	private long MODIFIED_BY;

	@Column(name = "MODIFIED_WHEN")
	private String MODIFIED_WHEN;

	@Column(name = "MODIFIED_WORKSTATION")
	private String MODIFIED_WORKSTATION;

	public long getPRODUCTCATERGORY_ID() {
		return PRODUCTCATERGORY_ID;
	}

	public void setPRODUCTCATERGORY_ID(long pRODUCTCATERGORY_ID) {
		PRODUCTCATERGORY_ID = pRODUCTCATERGORY_ID;
	}

	public String getPRODUCTCATERGORY_NAME() {
		return PRODUCTCATERGORY_NAME;
	}

	public void setPRODUCTCATERGORY_NAME(String pRODUCTCATERGORY_NAME) {
		PRODUCTCATERGORY_NAME = pRODUCTCATERGORY_NAME;
	}

	public String getPRODUCTCATERGORY_DESC() {
		return PRODUCTCATERGORY_DESC;
	}

	public void setPRODUCTCATERGORY_DESC(String pRODUCTCATERGORY_DESC) {
		PRODUCTCATERGORY_DESC = pRODUCTCATERGORY_DESC;
	}

	public String getISACTIVE() {
		return ISACTIVE;
	}

	public void setISACTIVE(String iSACTIVE) {
		ISACTIVE = iSACTIVE;
	}

	public long getMODIFIED_BY() {
		return MODIFIED_BY;
	}

	public void setMODIFIED_BY(long mODIFIED_BY) {
		MODIFIED_BY = mODIFIED_BY;
	}

	public String getMODIFIED_WHEN() {
		return MODIFIED_WHEN;
	}

	public void setMODIFIED_WHEN(String mODIFIED_WHEN) {
		MODIFIED_WHEN = mODIFIED_WHEN;
	}

	public String getMODIFIED_WORKSTATION() {
		return MODIFIED_WORKSTATION;
	}

	public void setMODIFIED_WORKSTATION(String mODIFIED_WORKSTATION) {
		MODIFIED_WORKSTATION = mODIFIED_WORKSTATION;
	}
	public static long getDatabaseTableID() {
		return (long) 3;
	}
	
}
