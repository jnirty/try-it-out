package com.example.semaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class ResourcePool{

	private static final int MAX_NUMBER_OF_PERMITS = 3;
	private final Queue<Resource> resources = new ConcurrentLinkedQueue<Resource>();
	private Semaphore sem = new Semaphore(MAX_NUMBER_OF_PERMITS, true);

	public Resource getMyResource(long maxWaitMillis) throws InterruptedException, ResourceCreateException {

		// try acquiring a permission to take or create MyResource
		sem.tryAcquire(maxWaitMillis, TimeUnit.MILLISECONDS);

		// take MyResource if available...
		Resource MyResource = resources.poll();
		if (MyResource != null) {
			return MyResource;
		}

		// ... or create one if no available
		try {
			return createResource();
		} catch (Exception exc) {
			sem.release();
			throw new ResourceCreateException();
		}
	}

	private Resource createResource() {
		resources.add(new Resource());
		return resources.poll();
	}

	public void giveBackMyResource(Resource MyResource) {
		resources.add(MyResource);
		sem.release();
	}
}
