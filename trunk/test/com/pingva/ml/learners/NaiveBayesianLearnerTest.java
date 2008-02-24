package com.pingva.ml.learners;

import com.pingva.ml.datagen.DataGenerator;
import com.pingva.ml.datagen.Distro;
import com.pingva.ml.datagen.GaussianDistro;
import com.pingva.ml.datagen.LearningData;

public class NaiveBayesianLearnerTest extends LearnerBaseTestCase {
	
	public void testWithGaussianDistro(){

		// create an array of "distributions".  
		// These "distributions" in fact produce constant samples, as provided in the constuctors
		
		Distro[] distros = { 
				new GaussianDistro(new float[] {0.3f}, new float[][] {{0.5f}}),
				new GaussianDistro(new float[] {0.7f}, new float[][] {{0.5f}}),
		};
		
		// produce learning data: 100 samples, with equiprobable classes.  feature vectors 
		// are distributed according to the distros created above
		LearningData data = DataGenerator.makeData(100, 0.5, distros);
		
		Learner learner = new NaiveBayesLearner();
		learner.learn(data);
		
		setLearner(learner);

		assertKlass(0,0.0);
		assertKlass(0,0.1);
		assertKlass(0,0.2);
		assertKlass(0,0.3);
		assertKlass(0,0.4);

		assertKlass(1,0.7);
		assertKlass(1,0.8);
		assertKlass(1,0.9);
	}
	

}
