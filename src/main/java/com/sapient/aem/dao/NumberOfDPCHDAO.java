package com.sapient.aem.dao;

import java.sql.SQLException;

public interface NumberOfDPCHDAO {
	public abstract Integer countOfDoctors() throws SQLException;
	public abstract Integer countOfPatients() throws SQLException;
	public abstract Integer pateintHistoryCount() throws SQLException;
	public abstract Integer pateintCaseSheetCount() throws SQLException;
}
