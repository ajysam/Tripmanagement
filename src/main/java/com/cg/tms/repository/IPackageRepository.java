package com.cg.tms.repository;

import java.util.List;

import com.cg.tms.exceptions.PackageNotFoundException;

public interface IPackageRepository {
	
	
	public  Package  addPackage(Package pack);
	public  Package  deletePackage(int packageId) throws PackageNotFoundException;
	public  Package  searchPackage(int packageId) throws PackageNotFoundException;
	public  List<Package> viewAllPackages();
	
	

}
