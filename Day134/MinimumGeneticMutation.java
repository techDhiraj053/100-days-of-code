/*
433. Minimum Genetic Mutation (State-Space BFS - DAY 134!)

This solution finds the minimum number of mutations to transform one gene 
string into another in O(N * L) time, where N is bank size and L is gene length.

Senior Twist: Dynamic State-Space Expansion.
By generating mutations on-the-fly from the current string and validating against 
a hash-backed gene bank, we perform a lean BFS traversal that avoids 
the memory overhead of constructing an explicit adjacency list for all strings.
*/
import java.util.Queue;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> validGeneBank = new HashSet<>(Arrays.asList(bank));

        // If endGene isn't reachable through the bank, short-circuit immediately
        if (!validGeneBank.contains(endGene)) {
            return -1;
        }

        Queue<String> mutationQueue = new LinkedList<>();
        Set<String> visitedGenes = new HashSet<>();
        char[] possibleNucleotides = {'A', 'C', 'G', 'T'};

        mutationQueue.offer(startGene);
        visitedGenes.add(startGene);
        
        int mutationCount = 0;

        while (!mutationQueue.isEmpty()) {
            int currentLevelSize = mutationQueue.size();

            // Process current mutation depth level
            for (int i = 0; i < currentLevelSize; i++) {
                String currentGene = mutationQueue.poll();

                if (currentGene.equals(endGene)) {
                    return mutationCount;
                }

                char[] geneChars = currentGene.toCharArray();

                // Explore all 24 possible single-point mutations
                for (int pos = 0; pos < geneChars.length; pos++) {
                    char originalChar = geneChars[pos];

                    for (char nucleotide : possibleNucleotides) {
                        if (nucleotide == originalChar) continue;

                        geneChars[pos] = nucleotide;
                        String mutatedGene = new String(geneChars);

                        // Only proceed if mutation is in bank and not previously explored
                        if (validGeneBank.contains(mutatedGene) && !visitedGenes.contains(mutatedGene)) {
                            visitedGenes.add(mutatedGene);
                            mutationQueue.offer(mutatedGene);
                        }
                    }
                    // Restore to original state before modifying next position
                    geneChars[pos] = originalChar;
                }
            }
            mutationCount++;
        }

        return -1; // End state unreachable
    }
}