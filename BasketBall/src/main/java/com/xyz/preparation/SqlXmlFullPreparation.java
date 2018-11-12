package com.xyz.preparation;

public class SqlXmlFullPreparation implements InitManager{

	@Override
	public void init(String mappingLocation) {
		
		
	}

	public enum Instance {
		
		SqlXmlFullPreparation;		
		private SqlXmlFullPreparation instance = null;
		
		private Instance() {
			instance = new SqlXmlFullPreparation();
		}
		public InitManager getInstance() {
			return instance;
		}
		
	}
}
