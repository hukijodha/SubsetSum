package com.hukam.subsetsum.logic;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

@Service
public class SubsetSumLogic {

	static boolean[][] dp;
	static String output = "";

	static void concatenateOutputString(ArrayList<Integer> v) {
		output = output.concat("<br />").concat(v.toString());

	}

	public synchronized String processInput(String inputStringArray, int sum) {
		int[] arr = changeStringtoArray(inputStringArray);
		if (arr != null) {

			printAllSubsets(arr, arr.length, sum);
			String outputtoSend = output;
			output = "";
			return outputtoSend.replaceAll("\\[", "").replaceAll(",", " ").replaceAll("\\]", "");

		} else {
			return "Invalid input array";
		}
	}

	static void printAllSubsets(int arr[], int n, int sum) {
		if (n == 0 || sum < 0)
			return;

		// Sum zero can always be achieved with Zero elements
		dp = new boolean[n][sum + 1];
		for (int i = 0; i < n; ++i) {
			dp[i][0] = true;
		}

		// Sum arr[0] can be achieved with single element
		if (arr[0] <= sum)
			dp[0][arr[0]] = true;

		// Fill rest of the entries in dp[][]
		for (int i = 1; i < n; ++i)
			for (int j = 0; j < sum + 1; ++j)
				dp[i][j] = (arr[i] <= j) ? (dp[i - 1][j] || dp[i - 1][j - arr[i]]) : dp[i - 1][j];
		if (dp[n - 1][sum] == false) {
			System.out.println("There are no subsets with" + " sum " + sum);
			output = "There are no subsets with sum :" + sum;
			return;
		}

		// Now recursively traversing dp[][] to find all
		// paths from dp[n-1][sum]
		ArrayList<Integer> p = new ArrayList<>();
		printSubsetsRec(arr, n - 1, sum, p);
	}

	static void printSubsetsRec(int arr[], int i, int sum, ArrayList<Integer> p) {
		// If reached end and sum is non-zero. Added to string
		// p[] only if arr[0] is equal to sun OR dp[0][sum]
		// is true.
		if (i == 0 && sum != 0 && dp[0][sum]) {
			p.add(arr[i]);
			concatenateOutputString(p);
			p.clear();
			return;
		}

		// If sum becomes 0
		if (i == 0 && sum == 0) {
			concatenateOutputString(p);
			p.clear();
			return;
		}

		// If given sum can be achieved after ignoring current element.
		if (dp[i - 1][sum]) {
			// Create a new vector to store path
			ArrayList<Integer> b = new ArrayList<>();
			b.addAll(p);
			printSubsetsRec(arr, i - 1, sum, b);
		}

		// If given sum can be achieved after considering current element.
		if (sum >= arr[i] && dp[i - 1][sum - arr[i]]) {
			p.add(arr[i]);
			printSubsetsRec(arr, i - 1, sum - arr[i], p);
		}
	}

	public int[] changeStringtoArray(String inputStringArray) {
		String[] items = inputStringArray.replaceAll("\\[", "").replaceAll("\\{", "").replaceAll("\\}", "")
				.replaceAll("\\]", "").replaceAll("\\s", "").split(",");

		int[] results = new int[items.length];

		for (int i = 0; i < items.length; i++) {
			try {
				results[i] = Integer.parseInt(items[i]);
			} catch (NumberFormatException nfe) {
				System.out.print("Input array is incorrect");
				return null;
			}
			;
		}
		return results;
	}

}
