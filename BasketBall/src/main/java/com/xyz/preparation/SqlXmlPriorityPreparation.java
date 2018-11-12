package com.xyz.preparation;

public class SqlXmlPriorityPreparation implements InitManager{

	@Override
	public void init(String mappingLocation) {
		// TODO Auto-generated method stub
		
	}
	public enum Instance {
		
		SqlXmlPriorityPreparation;		
		private SqlXmlPriorityPreparation instance = null;
		
		private Instance() {
			instance = new SqlXmlPriorityPreparation();
		}
		public InitManager getInstance() {
			return instance;
		}
		
	}
}
