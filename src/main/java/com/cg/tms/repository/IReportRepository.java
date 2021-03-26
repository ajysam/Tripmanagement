package com.cg.tms.repository;

import com.cg.tms.entities.Report;
import com.cg.tms.exceptions.ReportNotFoundException;

public interface IReportRepository {
	
	
		public Report  addReport(Report report);
		public Report  deleteReport(int reportId) throws ReportNotFoundException;
		public Report  viewReport(int reportId) throws ReportNotFoundException;
		public Report  viewAllReports();
		
	
	
	

}
