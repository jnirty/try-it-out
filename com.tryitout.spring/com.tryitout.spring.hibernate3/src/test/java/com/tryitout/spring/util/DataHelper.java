package com.tryitout.spring.util;

import java.io.File;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.dbunit.database.DatabaseConnection;
import org.dbunit.dataset.CompositeDataSet;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.SessionFactory;
import org.hibernate.jdbc.Work;

public class DataHelper {
	private SessionFactory testSessionFactory;

	public DataHelper(SessionFactory sessionFactory) {
		this.testSessionFactory = sessionFactory;
	}

	public void loadDatabaseData(String... entities) throws Exception {
		runDBUnitOperation(DatabaseOperation.CLEAN_INSERT, entities);
	}

	protected void runDBUnitOperation(final DatabaseOperation operation, final String... entities) throws Exception {
		testSessionFactory.getCurrentSession().doWork(new Work() {
			public void execute(Connection connection) {
				try {
					operation.execute(new DatabaseConnection(connection), dataSet(entities));
				} catch (Exception ex) {
					throw new RuntimeException(ex);
				}
			}
		});
	}

	protected IDataSet dataSet(String... entities) throws Exception {
		List<IDataSet> datasets = new ArrayList<IDataSet>();
		for (String entity : entities) {
			String location = "src/test/resources/datasets/" + entity + "/dataset.xml";
			datasets.add(new FlatXmlDataSetBuilder().build(new File(location)));
		}
		IDataSet[] datasetArray = new IDataSet[entities.length];
		return new CompositeDataSet(datasets.toArray(datasetArray));
	}
}
